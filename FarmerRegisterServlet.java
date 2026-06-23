import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/FarmerRegisterServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class FarmerRegisterServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String aadhaar = request.getParameter("aadhaar");
        String pan = request.getParameter("pan");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        String doorNo = request.getParameter("doorNo");
        String street = request.getParameter("street");
        String village = request.getParameter("village");
        String taluk = request.getParameter("taluk");
        String district = request.getParameter("district");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");

        String farmName = request.getParameter("farmName");
        String farmType = request.getParameter("farmType");
        String experience = request.getParameter("experience");
        String landSize = request.getParameter("landSize");
        String crops = request.getParameter("crops");
        String farmingDetails = request.getParameter("farmingDetails");

        String bankName = request.getParameter("bankName");
        String accountHolder = request.getParameter("accountHolder");
        String accountNumber = request.getParameter("accountNumber");
        String ifsc = request.getParameter("ifsc");
        String upiId = request.getParameter("upiId");
        String branchName = request.getParameter("branchName");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

      

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("", JDBC_USER, JDBC_PASSWORD);

            String sql = "INSERT INTO farmers (" +
                    "first_name, last_name, gender, dob, aadhaar, pan, email, mobile, " +
                    "door_no, street, village, taluk, district, state, pincode, " +
                    "farm_name, farm_type, experience, land_size, crops, farming_details, " +
                    "bank_name, account_holder, account_number, ifsc, upi_id, branch_name, " +
                    "username, password, profile_photo, land_document" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, aadhaar);
            ps.setString(6, pan);
            ps.setString(7, email);
            ps.setString(8, mobile);

            ps.setString(9, doorNo);
            ps.setString(10, street);
            ps.setString(11, village);
            ps.setString(12, taluk);
            ps.setString(13, district);
            ps.setString(14, state);
            ps.setString(15, pincode);

            ps.setString(16, farmName);
            ps.setString(17, farmType);
            ps.setString(18, experience);
            ps.setString(19, landSize);
            ps.setString(20, crops);
            ps.setString(21, farmingDetails);

            ps.setString(22, bankName);
            ps.setString(23, accountHolder);
            ps.setString(24, accountNumber);
            ps.setString(25, ifsc);
            ps.setString(26, upiId);
            ps.setString(27, branchName);

            ps.setString(28, username);
            ps.setString(29, password);
            

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Farmer details saved successfully</h2>");
                out.println("<p><a href='index.html'>Go Back Home</a></p>");
            } else {
                out.println("<h2>Failed to save farmer details</h2>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Database error: " + e.getMessage() + "</h3>");
        }
    }

    private String getFileName(Part part) {
        if (part == null) return null;
        String submittedFileName = part.getSubmittedFileName();
        if (submittedFileName == null) return null;
        return Paths.get(submittedFileName).getFileName().toString();
    }
}