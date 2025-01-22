Quản lý Kho Hàng - Ứng dụng Java sử dụng Mô hình Three Layer
Ứng dụng Quản lý Kho Hàng là một phần mềm được phát triển bằng ngôn ngữ Java, sử dụng mô hình ba lớp (Three Layer Architecture) để quản lý các sản phẩm trong kho, bao gồm các chức năng như thêm, sửa, xóa và tìm kiếm sản phẩm. Mô hình ba lớp giúp tách biệt các phần của ứng dụng, làm cho mã nguồn dễ bảo trì, mở rộng và kiểm tra.

Mô hình ba lớp (Three Layer Architecture)
Ứng dụng sử dụng mô hình ba lớp gồm:

Presentation Layer (Lớp giao diện người dùng): Đây là lớp giao tiếp với người dùng, chịu trách nhiệm hiển thị dữ liệu và nhận các hành động từ người dùng.
Business Logic Layer (Lớp xử lý nghiệp vụ): Chứa các logic nghiệp vụ và xử lý các yêu cầu từ lớp giao diện người dùng.
Data Access Layer (Lớp truy cập dữ liệu): Chịu trách nhiệm truy xuất và lưu trữ dữ liệu từ cơ sở dữ liệu (có thể sử dụng hệ quản trị cơ sở dữ liệu như MySQL, SQLite, v.v).
Các tính năng chính
Quản lý sản phẩm:
Thêm sản phẩm mới vào kho.
Sửa thông tin sản phẩm đã có.
Xóa sản phẩm khỏi kho.
Tìm kiếm sản phẩm theo tên hoặc mã sản phẩm.
Danh sách sản phẩm:
Hiển thị danh sách tất cả các sản phẩm trong kho.
Quản lý tồn kho:
Cập nhật số lượng sản phẩm khi có nhập hoặc xuất hàng.
Cấu trúc dự án
Dự án được tổ chức theo mô hình ba lớp với cấu trúc thư mục như sau:

less
Copy
warehouse-management/
│
├── src/
│   ├── presentation/        # Lớp giao diện người dùng
│   ├── businesslogic/       # Lớp xử lý nghiệp vụ
│   └── dataaccess/          # Lớp truy cập dữ liệu
│
├── resources/               # Tài nguyên (ví dụ: file cấu hình, ảnh, etc.)
└── README.md                # Tài liệu hướng dẫn sử dụng
Hướng dẫn cài đặt và chạy ứng dụng
1. Cài đặt môi trường
Trước khi bắt đầu, bạn cần cài đặt các công cụ sau:

Java Development Kit (JDK) phiên bản 8 trở lên.
IDE như IntelliJ IDEA, Eclipse, hoặc NetBeans để phát triển và chạy ứng dụng.
Cơ sở dữ liệu (tùy chọn): Bạn có thể sử dụng MySQL hoặc SQLite cho lớp truy cập dữ liệu.
2. Cài đặt cơ sở dữ liệu
Nếu bạn sử dụng MySQL hoặc SQLite, bạn cần tạo một cơ sở dữ liệu để lưu trữ thông tin về các sản phẩm trong kho. Ví dụ:

sql
Copy
CREATE DATABASE warehouse;
USE warehouse;

CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
3. Cấu hình ứng dụng
Chỉnh sửa file cấu hình để kết nối ứng dụng với cơ sở dữ liệu của bạn (ví dụ: application.properties hoặc config.properties).

4. Chạy ứng dụng
Mở dự án trong IDE.
Chạy ứng dụng Java từ lớp Main trong thư mục presentation.
Các lớp trong dự án
Lớp Product (Model)
Đại diện cho một sản phẩm trong kho, với các thuộc tính như productId, productName, quantity, price.

Lớp ProductService (Business Logic Layer)
Chứa các phương thức xử lý nghiệp vụ liên quan đến sản phẩm như thêm mới, sửa, xóa, tìm kiếm và cập nhật số lượng.

Lớp ProductDAO (Data Access Layer)
Đảm nhận việc giao tiếp với cơ sở dữ liệu để thực hiện các thao tác thêm, sửa, xóa và truy vấn dữ liệu sản phẩm.

Lớp ProductController (Presentation Layer)
Lớp này tiếp nhận các yêu cầu từ người dùng và gọi các phương thức thích hợp từ ProductService để xử lý các yêu cầu và trả kết quả lại cho người dùng.

Công nghệ và công cụ
Java 8+
MySQL hoặc SQLite (tuỳ chọn)
JDBC (Java Database Connectivity) để kết nối với cơ sở dữ liệu.
Maven (hoặc Gradle) để quản lý phụ thuộc (dependencies).
Cách đóng góp
Nếu bạn muốn đóng góp vào dự án, vui lòng thực hiện các bước sau:

Fork repo này.
Tạo nhánh mới (git checkout -b feature-branch).
Commit các thay đổi của bạn (git commit -am 'Add new feature').
Push nhánh lên repo của bạn (git push origin feature-branch).
Mở Pull Request để chúng tôi xem xét.
Giấy phép
Dự án này được phát hành dưới Giấy phép MIT. Bạn có thể tham khảo thêm tại LICENSE.
