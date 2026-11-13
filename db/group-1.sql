-- ============================================================================
-- DATABASE CREATION: WEBSITE BÁN IPHONE CŨ QUA KIỂM ĐỊNH (45 TABLES)
-- Target RDBMS: SQL Server 2016+ / Azure SQL
-- ============================================================================

CREATE DATABASE [iPhoneQCStore];
GO

USE [iPhoneQCStore];
GO

-- ============================================================================
-- PHÂN HỆ 1: NGƯỜI DÙNG & PHÂN QUYỀN (USER, AUTH & RBAC) - 6 BẢNG
-- ============================================================================

-- 1. Bảng người dùng (Chung cho Khách hàng & Nhân viên)
CREATE TABLE [users] (
    [user_id] INT IDENTITY(1,1) PRIMARY KEY,
    [email] NVARCHAR(255) NOT NULL UNIQUE,
    [phone_number] VARCHAR(20) NULL UNIQUE,
    [password_hash] NVARCHAR(255) NOT NULL,
    [full_name] NVARCHAR(100) NOT NULL,
    [avatar_url] NVARCHAR(500) NULL,
    [status] NVARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK ([status] IN ('ACTIVE', 'INACTIVE', 'LOCKED')),
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE(),
    [updated_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 2. Mã xác thực OTP/Email/SMS
CREATE TABLE [user_verifications] (
    [verification_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [type] NVARCHAR(20) NOT NULL CHECK ([type] IN ('EMAIL', 'PHONE', 'RECOVERY')),
    [code] VARCHAR(10) NOT NULL,
    [expires_at] DATETIME2 NOT NULL,
    [is_verified] BIT NOT NULL DEFAULT 0
);

-- 3. Sổ địa chỉ nhận hàng
CREATE TABLE [shipping_addresses] (
    [address_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [recipient_name] NVARCHAR(100) NOT NULL,
    [phone] VARCHAR(20) NOT NULL,
    [province] NVARCHAR(100) NOT NULL,
    [district] NVARCHAR(100) NOT NULL,
    [ward] NVARCHAR(100) NOT NULL,
    [detailed_address] NVARCHAR(255) NOT NULL,
    [is_default] BIT NOT NULL DEFAULT 0
);

-- 4. Vai trò hệ thống
CREATE TABLE [roles] (
    [role_id] INT IDENTITY(1,1) PRIMARY KEY,
    [role_code] VARCHAR(50) NOT NULL UNIQUE, -- ADMIN, INSPECTOR, SELLER, TECHNICIAN, BUYER_STAFF
    [role_name] NVARCHAR(100) NOT NULL,
    [description] NVARCHAR(255) NULL
);

-- 5. Quyền chi tiết trong hệ thống
CREATE TABLE [permissions] (
    [permission_id] INT IDENTITY(1,1) PRIMARY KEY,
    [permission_code] VARCHAR(100) NOT NULL UNIQUE,
    [permission_name] NVARCHAR(100) NOT NULL,
    [module] VARCHAR(50) NOT NULL
);

-- 6. Gán vai trò cho nhân viên
CREATE TABLE [user_roles] (
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [role_id] INT NOT NULL FOREIGN KEY REFERENCES [roles]([role_id]) ON DELETE CASCADE,
    [assigned_at] DATETIME2 NOT NULL DEFAULT GETDATE(),
    PRIMARY KEY ([user_id], [role_id])
);

-- ============================================================================
-- PHÂN HỆ 2: DANH MỤC & THÔNG SỐ KỸ THUẬT IPHONE (MASTER CATALOG) - 5 BẢNG
-- ============================================================================

-- 7. Dòng iPhone (Models)
CREATE TABLE [iphone_models] (
    [model_id] INT IDENTITY(1,1) PRIMARY KEY,
    [model_name] NVARCHAR(100) NOT NULL UNIQUE, -- e.g., iPhone 13 Pro Max
    [generation] NVARCHAR(50) NULL,
    [release_year] INT NULL,
    [original_msrp] DECIMAL(18,2) NULL,
    [status] NVARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
);

-- 8. Phân loại dung lượng
CREATE TABLE [iphone_capacities] (
    [capacity_id] INT IDENTITY(1,1) PRIMARY KEY,
    [capacity_value] VARCHAR(20) NOT NULL UNIQUE -- 128GB, 256GB, 512GB, 1TB
);

-- 9. Danh mục màu sắc
CREATE TABLE [iphone_colors] (
    [color_id] INT IDENTITY(1,1) PRIMARY KEY,
    [color_name] NVARCHAR(50) NOT NULL UNIQUE,
    [hex_code] VARCHAR(10) NULL
);

-- 10. Phiên bản biến thể (Model + Capacity + Color)
CREATE TABLE [iphone_variants] (
    [variant_id] INT IDENTITY(1,1) PRIMARY KEY,
    [model_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_models]([model_id]),
    [capacity_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_capacities]([capacity_id]),
    [color_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_colors]([color_id]),
    [model_number] VARCHAR(50) NULL, -- Mã máy: LL/A, VN/A, J/A...
    [sku] VARCHAR(50) NOT NULL UNIQUE
);

-- 11. Thông số kỹ thuật chi tiết
CREATE TABLE [iphone_specifications] (
    [spec_id] INT IDENTITY(1,1) PRIMARY KEY,
    [model_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_models]([model_id]) ON DELETE CASCADE,
    [screen_size] VARCHAR(50) NULL,
    [chipset] VARCHAR(100) NULL,
    [ram] VARCHAR(20) NULL,
    [camera_specs] NVARCHAR(255) NULL,
    [battery_capacity_mah] INT NULL,
    [charging_tech] NVARCHAR(255) NULL,
    [biometrics_type] VARCHAR(50) NULL -- FaceID / TouchID
);

-- ============================================================================
-- PHÂN HỆ 3: QUẢN LÝ KHO THIẾT BỊ & ĐỊNH DANH IMEI (INVENTORY & DEVICE) - 4 BẢNG
-- ============================================================================

-- 12. Quản lý từng chiếc iPhone cụ thể theo IMEI
CREATE TABLE [devices] (
    [device_id] INT IDENTITY(1,1) PRIMARY KEY,
    [variant_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_variants]([variant_id]),
    [imei] VARCHAR(20) NOT NULL UNIQUE,
    [serial_number] VARCHAR(50) NOT NULL UNIQUE,
    [origin_country] NVARCHAR(100) NULL,
    [status] NVARCHAR(30) NOT NULL DEFAULT 'DRAFT' 
        CHECK ([status] IN ('DRAFT', 'WAITING_INSPECT', 'IN_STOCK', 'RESERVED', 'SOLD', 'RETURNED', 'REJECTED')),
    [is_visible] BIT NOT NULL DEFAULT 0, -- Ẩn/Hiện trên Web
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 13. Hình ảnh & Video thực tế của máy
CREATE TABLE [device_media] (
    [media_id] INT IDENTITY(1,1) PRIMARY KEY,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]) ON DELETE CASCADE,
    [media_type] VARCHAR(10) NOT NULL CHECK ([media_type] IN ('IMAGE', 'VIDEO')),
    [media_url] NVARCHAR(500) NOT NULL,
    [is_cover] BIT NOT NULL DEFAULT 0,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 14. Danh sách sản phẩm yêu thích của khách
CREATE TABLE [user_wishlists] (
    [wishlist_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]) ON DELETE CASCADE,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE(),
    CONSTRAINT [UQ_user_device_wishlist] UNIQUE([user_id], [device_id])
);

-- 15. Đăng ký nhận thông báo khi có hàng
CREATE TABLE [stock_notifications] (
    [notification_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [variant_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_variants]([variant_id]),
    [preferred_quality_tier] VARCHAR(10) NULL, -- Grade A, B, C
    [status] NVARCHAR(20) NOT NULL DEFAULT 'PENDING',
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- ============================================================================
-- PHÂN HỆ 4: QUY TRÌNH THU MUA IPHONE CŨ (TRADE-IN / BUYBACK) - 4 BẢNG
-- ============================================================================

-- 16. Yêu cầu bán lại từ khách hàng
CREATE TABLE [tradein_requests] (
    [request_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [seller_name] NVARCHAR(100) NOT NULL,
    [seller_phone] VARCHAR(20) NOT NULL,
    [seller_email] NVARCHAR(255) NULL,
    [model_name] NVARCHAR(100) NOT NULL,
    [capacity] VARCHAR(20) NULL,
    [user_described_condition] NVARCHAR(MAX) NULL,
    [status] NVARCHAR(30) NOT NULL DEFAULT 'PENDING'
        CHECK ([status] IN ('PENDING', 'APPROVED', 'INSPECTING', 'COMPLETED', 'CANCELLED', 'REJECTED')),
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 17. Ảnh thiết bị do khách tải lên
CREATE TABLE [tradein_images] (
    [image_id] INT IDENTITY(1,1) PRIMARY KEY,
    [request_id] INT NOT NULL FOREIGN KEY REFERENCES [tradein_requests]([request_id]) ON DELETE CASCADE,
    [image_url] NVARCHAR(500) NOT NULL,
    [uploaded_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 18. Lịch hẹn tiếp nhận / Kiểm tra máy
CREATE TABLE [tradein_appointments] (
    [appointment_id] INT IDENTITY(1,1) PRIMARY KEY,
    [request_id] INT NOT NULL FOREIGN KEY REFERENCES [tradein_requests]([request_id]) ON DELETE CASCADE,
    [appointment_date] DATETIME2 NOT NULL,
    [location_type] NVARCHAR(20) NOT NULL CHECK ([location_type] IN ('STORE', 'HOME')),
    [address] NVARCHAR(255) NULL,
    [status] NVARCHAR(20) NOT NULL DEFAULT 'SCHEDULED'
);

-- 19. Phiếu tiếp nhận & Giao dịch thu mua
CREATE TABLE [tradein_receipts] (
    [receipt_id] INT IDENTITY(1,1) PRIMARY KEY,
    [request_id] INT NOT NULL FOREIGN KEY REFERENCES [tradein_requests]([request_id]),
    [device_id] INT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [inspector_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [initial_estimated_price] DECIMAL(18,2) NULL,
    [final_offer_price] DECIMAL(18,2) NULL,
    [rejection_reason] NVARCHAR(500) NULL,
    [transaction_status] NVARCHAR(20) NOT NULL DEFAULT 'PENDING'
        CHECK ([transaction_status] IN ('PENDING', 'ACCEPTED', 'REJECTED', 'PAID')),
    [paid_at] DATETIME2 NULL
);

-- ============================================================================
-- PHÂN HỆ 5: QUY TRÌNH KIỂM ĐỊNH & ĐÁNH GIÁ CHẤT LƯỢNG (QC) - 7 BẢNG
-- ============================================================================

-- 20. Danh mục lỗi phần cứng
CREATE TABLE [hardware_fault_catalog] (
    [fault_id] INT IDENTITY(1,1) PRIMARY KEY,
    [fault_code] VARCHAR(50) NOT NULL UNIQUE,
    [fault_name] NVARCHAR(150) NOT NULL,
    [category] NVARCHAR(50) NOT NULL
);

-- 21. Danh mục linh kiện iPhone
CREATE TABLE [iphone_parts_catalog] (
    [part_id] INT IDENTITY(1,1) PRIMARY KEY,
    [part_name] NVARCHAR(100) NOT NULL UNIQUE -- Màn hình, Pin, Camera, Vỏ...
);

-- 22. Tiêu chí & Trọng số chấm điểm
CREATE TABLE [quality_grading_criteria] (
    [criterion_id] INT IDENTITY(1,1) PRIMARY KEY,
    [criterion_name] NVARCHAR(150) NOT NULL,
    [category] VARCHAR(30) NOT NULL CHECK ([category] IN ('COSMETIC', 'BATTERY', 'COMPONENT', 'FUNCTION')),
    [weight] DECIMAL(5,2) NOT NULL DEFAULT 1.00
);

-- 23. Phiếu kiểm định chất lượng iPhone
CREATE TABLE [inspection_tickets] (
    [ticket_id] INT IDENTITY(1,1) PRIMARY KEY,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [inspector_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [inspection_date] DATETIME2 NOT NULL DEFAULT GETDATE(),
    [status] NVARCHAR(20) NOT NULL DEFAULT 'IN_PROGRESS' 
        CHECK ([status] IN ('IN_PROGRESS', 'COMPLETED', 'RE_INSPECTED'))
);

-- 24. Chi tiết kiểm tra ngoại hình & Chức năng (30+ hạng mục)
CREATE TABLE [inspection_details] (
    [detail_id] INT IDENTITY(1,1) PRIMARY KEY,
    [ticket_id] INT NOT NULL FOREIGN KEY REFERENCES [inspection_tickets]([ticket_id]) ON DELETE CASCADE,
    [check_item] NVARCHAR(100) NOT NULL, -- Screen Scratch, FaceID, TrueTone, Wifi...
    [result_status] VARCHAR(10) NOT NULL CHECK ([result_status] IN ('PASSED', 'FAILED', 'WARN')),
    [grade_value] NVARCHAR(50) NULL,
    [notes] NVARCHAR(255) NULL
);

-- 25. Kiểm tra linh kiện thay thế & Khóa iCloud/IMEI
CREATE TABLE [inspection_component_checks] (
    [component_check_id] INT IDENTITY(1,1) PRIMARY KEY,
    [ticket_id] INT NOT NULL FOREIGN KEY REFERENCES [inspection_tickets]([ticket_id]) ON DELETE CASCADE,
    [part_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_parts_catalog]([part_id]),
    [is_original] BIT NOT NULL DEFAULT 1,
    [is_genuine_replaced] BIT NOT NULL DEFAULT 0,
    [icloud_status] VARCHAR(20) NOT NULL DEFAULT 'CLEAN' CHECK ([icloud_status] IN ('CLEAN', 'LOCKED')),
    [sim_lock_status] VARCHAR(20) NOT NULL DEFAULT 'UNLOCKED' CHECK ([sim_lock_status] IN ('UNLOCKED', 'LOCKED')),
    [blacklisted_check] VARCHAR(20) NOT NULL DEFAULT 'CLEAN' CHECK ([blacklisted_check] IN ('CLEAN', 'LOST_STOLEN')),
    [proof_image_url] NVARCHAR(500) NULL
);

-- 26. Log kiểm định Pin chi tiết
CREATE TABLE [inspection_battery_logs] (
    [battery_log_id] INT IDENTITY(1,1) PRIMARY KEY,
    [ticket_id] INT NOT NULL FOREIGN KEY REFERENCES [inspection_tickets]([ticket_id]) ON DELETE CASCADE,
    [battery_health_percentage] INT NOT NULL CHECK ([battery_health_percentage] BETWEEN 0 AND 100),
    [charge_cycles] INT NOT NULL DEFAULT 0,
    [is_original_battery] BIT NOT NULL DEFAULT 1,
    [battery_warning_status] BIT NOT NULL DEFAULT 0, -- Có thông báo bảo trì hay không
    [quality_tier] NVARCHAR(30) NULL
);

-- ============================================================================
-- PHÂN HỆ 6: CHỨNG NHẬN, XẾP HẠNG GRADE & MA TRẬN GIÁ - 5 BẢNG
-- ============================================================================

-- 27. Chứng nhận kiểm định thiết bị
CREATE TABLE [quality_certificates] (
    [cert_id] INT IDENTITY(1,1) PRIMARY KEY,
    [cert_code] VARCHAR(50) NOT NULL UNIQUE,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [ticket_id] INT NOT NULL FOREIGN KEY REFERENCES [inspection_tickets]([ticket_id]),
    [overall_score] DECIMAL(4,2) NOT NULL,
    [quality_tier] VARCHAR(10) NOT NULL CHECK ([quality_tier] IN ('GRADE_A', 'GRADE_B', 'GRADE_C')),
    [issued_at] DATETIME2 NOT NULL DEFAULT GETDATE(),
    [pdf_report_url] NVARCHAR(500) NULL
);

-- 28. Bảng giá tham chiếu theo dòng
CREATE TABLE [pricing_reference_matrices] (
    [matrix_id] INT IDENTITY(1,1) PRIMARY KEY,
    [variant_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_variants]([variant_id]),
    [base_new_price] DECIMAL(18,2) NOT NULL,
    [base_used_price] DECIMAL(18,2) NOT NULL,
    [updated_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 29. Quy tắc giảm giá & Khấu hao QC
CREATE TABLE [depreciation_rules] (
    [rule_id] INT IDENTITY(1,1) PRIMARY KEY,
    [rule_type] VARCHAR(50) NOT NULL, -- AGE, COSMETIC_GRADE, BATTERY_LEVEL, REPLACED_PART
    [min_val] DECIMAL(10,2) NULL,
    [max_val] DECIMAL(10,2) NULL,
    [deduction_amount] DECIMAL(18,2) DEFAULT 0,
    [deduction_percentage] DECIMAL(5,2) DEFAULT 0
);

-- 30. Lịch sử biến động giá thiết bị
CREATE TABLE [device_price_logs] (
    [log_id] INT IDENTITY(1,1) PRIMARY KEY,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [suggested_buyin_price] DECIMAL(18,2) NULL,
    [suggested_selling_price] DECIMAL(18,2) NULL,
    [actual_selling_price] DECIMAL(18,2) NOT NULL,
    [market_adjustment] DECIMAL(18,2) DEFAULT 0,
    [changed_at] DATETIME2 NOT NULL DEFAULT GETDATE(),
    [changed_by] INT NULL FOREIGN KEY REFERENCES [users]([user_id])
);

-- 31. Cache dữ liệu so sánh giá nhanh
CREATE TABLE [price_comparisons_cache] (
    [cache_id] INT IDENTITY(1,1) PRIMARY KEY,
    [variant_id] INT NOT NULL FOREIGN KEY REFERENCES [iphone_variants]([variant_id]),
    [quality_tier] VARCHAR(10) NOT NULL,
    [avg_battery_health] INT NULL,
    [avg_price] DECIMAL(18,2) NOT NULL,
    [savings_vs_new] DECIMAL(18,2) NOT NULL
);

-- ============================================================================
-- PHÂN HỆ 7: ĐƠN HÀNG, GIỎ HÀNG & THANH TOÁN (ORDERS & PAYMENTS) - 4 BẢNG
-- ============================================================================

-- 32. Giỏ hàng của khách (Mỗi device_id là duy nhất)
CREATE TABLE [cart_items] (
    [cart_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE CASCADE,
    [device_id] INT NOT NULL UNIQUE FOREIGN KEY REFERENCES [devices]([device_id]),
    [added_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 33. Mã giảm giá / Voucher
CREATE TABLE [coupons] (
    [coupon_id] INT IDENTITY(1,1) PRIMARY KEY,
    [code] VARCHAR(50) NOT NULL UNIQUE,
    [discount_type] VARCHAR(10) NOT NULL CHECK ([discount_type] IN ('PERCENT', 'FIXED')),
    [discount_value] DECIMAL(18,2) NOT NULL,
    [min_order_value] DECIMAL(18,2) DEFAULT 0,
    [start_date] DATETIME2 NOT NULL,
    [end_date] DATETIME2 NOT NULL,
    [usage_limit] INT DEFAULT 100
);

-- 34. Đơn đặt hàng
CREATE TABLE [orders] (
    [order_id] INT IDENTITY(1,1) PRIMARY KEY,
    [order_code] VARCHAR(50) NOT NULL UNIQUE,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [recipient_name] NVARCHAR(100) NOT NULL,
    [recipient_phone] VARCHAR(20) NOT NULL,
    [shipping_address] NVARCHAR(255) NOT NULL,
    [shipping_method] NVARCHAR(50) NOT NULL,
    [total_amount] DECIMAL(18,2) NOT NULL,
    [discount_amount] DECIMAL(18,2) DEFAULT 0,
    [final_amount] DECIMAL(18,2) NOT NULL,
    [order_status] NVARCHAR(30) NOT NULL DEFAULT 'PENDING'
        CHECK ([order_status] IN ('PENDING', 'CONFIRMED', 'SHIPPING', 'DELIVERED', 'CANCELLED')),
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 35. Chi tiết sản phẩm đơn hàng & Bảng thanh toán
CREATE TABLE [order_items] (
    [order_item_id] INT IDENTITY(1,1) PRIMARY KEY,
    [order_id] INT NOT NULL FOREIGN KEY REFERENCES [orders]([order_id]) ON DELETE CASCADE,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [unit_price] DECIMAL(18,2) NOT NULL,
    CONSTRAINT [UQ_order_device] UNIQUE([order_id], [device_id])
);

CREATE TABLE [payments] (
    [payment_id] INT IDENTITY(1,1) PRIMARY KEY,
    [order_id] INT NOT NULL FOREIGN KEY REFERENCES [orders]([order_id]) ON DELETE CASCADE,
    [payment_method] VARCHAR(20) NOT NULL CHECK ([payment_method] IN ('COD', 'VNPAY', 'ZALOPAY', 'BANK_TRANSFER')),
    [transaction_code] VARCHAR(100) NULL,
    [payment_status] VARCHAR(20) NOT NULL DEFAULT 'PENDING' CHECK ([payment_status] IN ('PENDING', 'PAID', 'FAILED')),
    [paid_at] DATETIME2 NULL
);

-- ============================================================================
-- PHÂN HỆ 8: GÓI BẢO HÀNH & SỬA CHỮA (WARRANTY SYSTEM) - 4 BẢNG
-- ============================================================================

-- 36. Danh mục gói bảo hành
CREATE TABLE [warranty_packages] (
    [package_id] INT IDENTITY(1,1) PRIMARY KEY,
    [package_name] NVARCHAR(100) NOT NULL,
    [duration_months] INT NOT NULL,
    [coverage_terms] NVARCHAR(MAX) NULL,
    [quality_tier_applied] VARCHAR(10) NULL
);

-- 37. Phiếu bảo hành điện tử theo IMEI
CREATE TABLE [e_warranty_cards] (
    [card_id] INT IDENTITY(1,1) PRIMARY KEY,
    [warranty_code] VARCHAR(50) NOT NULL UNIQUE,
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [order_id] INT NOT NULL FOREIGN KEY REFERENCES [orders]([order_id]),
    [package_id] INT NOT NULL FOREIGN KEY REFERENCES [warranty_packages]([package_id]),
    [start_date] DATETIME2 NOT NULL,
    [end_date] DATETIME2 NOT NULL,
    [status] VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK ([status] IN ('ACTIVE', 'EXPIRED', 'VOID'))
);

-- 38. Yêu cầu bảo hành / đổi trả
CREATE TABLE [warranty_requests] (
    [request_id] INT IDENTITY(1,1) PRIMARY KEY,
    [card_id] INT NOT NULL FOREIGN KEY REFERENCES [e_warranty_cards]([card_id]),
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [reported_fault_description] NVARCHAR(MAX) NOT NULL,
    [request_type] VARCHAR(20) NOT NULL CHECK ([request_type] IN ('REPAIR', 'RETURN_REFUND')),
    [status] NVARCHAR(30) NOT NULL DEFAULT 'RECEIVED'
        CHECK ([status] IN ('RECEIVED', 'APPROVED', 'REJECTED', 'IN_REPAIR', 'COMPLETED')),
    [rejection_reason] NVARCHAR(500) NULL,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 39. Nhật ký kỹ thuật viên sửa chữa
CREATE TABLE [warranty_repair_logs] (
    [repair_log_id] INT IDENTITY(1,1) PRIMARY KEY,
    [request_id] INT NOT NULL FOREIGN KEY REFERENCES [warranty_requests]([request_id]),
    [technician_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [fault_diagnosed] NVARCHAR(255) NULL,
    [replaced_part_name] NVARCHAR(100) NULL,
    [repair_result] NVARCHAR(MAX) NULL,
    [completed_at] DATETIME2 NULL
);

-- ============================================================================
-- PHÂN HỆ 9: ĐÁNH GIÁ, KHIẾU NẠI & HỖ TRỢ (FEEDBACK & SUPPORT) - 3 BẢNG
-- ============================================================================

-- 40. Đánh giá sản phẩm & Độ chuẩn QC
CREATE TABLE [product_reviews] (
    [review_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [device_id] INT NOT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [overall_rating] INT NOT NULL CHECK ([overall_rating] BETWEEN 1 AND 5),
    [qc_accuracy_rating] INT NOT NULL CHECK ([qc_accuracy_rating] BETWEEN 1 AND 5),
    [battery_post_use_rating] INT NULL CHECK ([battery_post_use_rating] BETWEEN 1 AND 5),
    [comment] NVARCHAR(MAX) NULL,
    [review_image_url] NVARCHAR(500) NULL,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 41. Báo cáo & Khiếu nại từ khách hàng
CREATE TABLE [customer_complaints] (
    [complaint_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [device_id] INT NULL FOREIGN KEY REFERENCES [devices]([device_id]),
    [complaint_type] VARCHAR(30) NOT NULL CHECK ([complaint_type] IN ('INACCURATE_SPEC', 'MISLEADING_QC', 'SERVICE')),
    [content] NVARCHAR(MAX) NOT NULL,
    [status] NVARCHAR(20) NOT NULL DEFAULT 'OPEN',
    [resolution_note] NVARCHAR(MAX) NULL,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 42. Ticket hỗ trợ kỹ thuật / Tư vấn
CREATE TABLE [support_tickets] (
    [ticket_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [subject] NVARCHAR(200) NOT NULL,
    [message] NVARCHAR(MAX) NOT NULL,
    [support_type] VARCHAR(20) NOT NULL CHECK ([support_type] IN ('CONSULT', 'TECHNICAL')),
    [status] NVARCHAR(20) NOT NULL DEFAULT 'OPEN',
    [assigned_staff_id] INT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- ============================================================================
-- PHÂN HỆ 10: NHẬT KÝ HỆ THỐNG & THỐNG KÊ (AUDIT & ANALYTICS) - 3 BẢNG
-- ============================================================================

-- 43. Lịch sử tìm kiếm & Bộ lọc sản phẩm
CREATE TABLE [user_search_histories] (
    [search_id] INT IDENTITY(1,1) PRIMARY KEY,
    [user_id] INT NULL FOREIGN KEY REFERENCES [users]([user_id]) ON DELETE SET NULL,
    [search_keyword] NVARCHAR(255) NULL,
    [applied_filters_json] NVARCHAR(MAX) NULL, -- Lưu bộ lọc price, battery, grade...
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 44. Audit Log nhân viên
CREATE TABLE [staff_audit_logs] (
    [log_id] INT IDENTITY(1,1) PRIMARY KEY,
    [staff_id] INT NOT NULL FOREIGN KEY REFERENCES [users]([user_id]),
    [action] VARCHAR(50) NOT NULL, -- CREATE, UPDATE, DELETE, CHANGE_STATUS
    [target_table] VARCHAR(50) NOT NULL,
    [target_id] INT NULL,
    [description] NVARCHAR(MAX) NULL,
    [ip_address] VARCHAR(45) NULL,
    [created_at] DATETIME2 NOT NULL DEFAULT GETDATE()
);

-- 45. Tổng hợp báo cáo kinh doanh theo ngày (Hỗ trợ Xuất Excel)
CREATE TABLE [daily_business_analytics] (
    [stat_date] DATE PRIMARY KEY,
    [total_tradein_count] INT DEFAULT 0,
    [passed_qc_count] INT DEFAULT 0,
    [failed_qc_count] INT DEFAULT 0,
    [low_battery_count] INT DEFAULT 0,
    [replaced_parts_count] INT DEFAULT 0,
    [total_revenue] DECIMAL(18,2) DEFAULT 0,
    [total_tradein_cost] DECIMAL(18,2) DEFAULT 0,
    [gross_profit] DECIMAL(18,2) DEFAULT 0,
    [total_warranty_requests] INT DEFAULT 0,
    [approved_warranty_count] INT DEFAULT 0,
    [avg_qc_processing_time_mins] INT DEFAULT 0
);
GO

-- ============================================================================
-- TẠO INDEX TỐI ƯU HIỆU NĂNG TÌM KIẾM VA LỌC SẢN PHẨM (INDEXES)
-- ============================================================================

-- Tìm kiếm máy theo IMEI / Serial nhanh chóng
CREATE INDEX IX_devices_imei ON [devices]([imei]);
CREATE INDEX IX_devices_status_visible ON [devices]([status], [is_visible]);

-- Tra cứu chứng nhận kiểm định
CREATE INDEX IX_quality_certificates_code ON [quality_certificates]([cert_code]);

-- Lọc đơn hàng & bảo hành
CREATE INDEX IX_orders_user ON [orders]([user_id]);
CREATE INDEX IX_e_warranty_code ON [e_warranty_cards]([warranty_code]);
GO
