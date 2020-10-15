package servlet;

import Db.ConnectDb;
import items.BookItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AddToDb extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        String price = req.getParameter("price");
        String image = req.getParameter("img");

        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        if (!isMultipartContent) {
            return;
        }

        System.out.println(title + " " + desc + " " + price + " " + image);

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        FileItem fileItem = null;
        try {
            List<FileItem> fields = upload.parseRequest(req);
            Iterator<FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                fileItem = it.next();
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        ConnectDb db = new ConnectDb();
        db.addBook(new BookItem(title, desc, 23, fileItem.toString()));
    }
}
