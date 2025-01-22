# Quản Lý Kho Hàng - Ứng Dụng Java Swing sử dụng Mô Hình Three Layer

Ứng dụng **Quản Lý Kho Hàng** được phát triển bằng **Java Swing** với **MySQL** và mô hình ba lớp (Three Layer Architecture). Ứng dụng giúp quản lý sản phẩm trong kho với các chức năng như thêm, sửa, xóa và tìm kiếm sản phẩm.

## Mô Hình Ba Lớp

1. **Presentation Layer**: Giao diện người dùng (sử dụng Java Swing).
2. **Business Logic Layer**: Xử lý nghiệp vụ (lógica xử lý các thao tác).
3. **Data Access Layer**: Giao tiếp với cơ sở dữ liệu **MySQL**.

## Các Tính Năng

- Thêm, sửa, xóa và tìm kiếm sản phẩm.
- Hiển thị danh sách sản phẩm trong kho.
- Quản lý tồn kho (cập nhật số lượng khi nhập/xuất hàng).

## Cấu Trúc Dự Án

warehouse-management/
│
├── src/
│   ├── presentation/        # Lớp giao diện (Java Swing)
│   ├── businesslogic/       # Lớp xử lý nghiệp vụ
│   └── dataaccess/          # Lớp truy cập dữ liệu MySQL
│
└── README.md                # Tài liệu hướng dẫn sử dụng

Công Nghệ
Java 8+
MySQL (JDBC để kết nối cơ sở dữ liệu)
Java Swing (giao diện người dùng)
Maven (quản lý phụ thuộc)
