package main.java.net.vartanian.controllers;

import main.java.net.vartanian.dao.impl.MapProductDaoImpl;
import main.java.net.vartanian.datastore.mapdatastore.MapDataStoreImpl;
import main.java.net.vartanian.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by i.vartanian on 08.10.2014.
 */
public class ProductController extends HttpServlet {

    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    private MapProductDaoImpl productDao = new MapProductDaoImpl(new MapDataStoreImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("id");

        Product product = productDao.searchById(idStr);
        if (product != null) {
            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_OK);
            requestDispatcher.forward(request, response);
            return;
        }
        response.sendRedirect(PAGE_ERROR);

//        response.setContentType("text/html; charset=UTF-8");
//        Product product = new Product("1", "Solt");
//        PrintWriter writer = response.getWriter();
//        writer.print(product.getId());
//        writer.close();

    }

}