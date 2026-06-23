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

@WebServlet("/CustomerRegisterServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class CustomerRegisterServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/v2vfxt";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "arjun";

    //private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        String doorNo = request.getParameter("doorNo");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String landmark = request.getParameter("landmark");
        String addressNotes = request.getParameter("addressNotes");

        String language = request.getParameter("language");
        String contactMethod = request.getParameter("contactMethod");
        String preferences = request.getParameter("preferences");
        String additionalRequests = request.getParameter("additionalRequests");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String paymentMethod = request.getParameter("paymentMethod");
        String upiId = request.getParameter("upiId");




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "INSERT INTO customers (" +
                    "first_name, last_name, gender, dob, email, mobile, " +
                    "door_no, street, city, state, pincode, landmark, address_notes, " +
                    "language, contact_method, preferences, additional_requests, " +
                    "username, password, payment_method, upi_id, profile_photo, address_proof" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, email);
            ps.setString(6, mobile);

            ps.setString(7, doorNo);
            ps.setString(8, street);
            ps.setString(9, city);
            ps.setString(10, state);
            ps.setString(11, pincode);
            ps.setString(12, landmark);
            ps.setString(13, addressNotes);

            ps.setString(14, language);
            ps.setString(15, contactMethod);
            ps.setString(16, preferences);
            ps.setString(17, additionalRequests);

            ps.setString(18, username);
            ps.setString(19, password);
            ps.setString(20, paymentMethod);
            ps.setString(21, upiId);
            ps.setString(22, profilePhotoName);
            ps.setString(23, addressProofName);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Customer details saved successfully</h2>");
                out.println("<p><a href='index.html'>Go Back Home</a></p>");
            } else {
                out.println("<h2>Failed to save customer details</h2>");
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