package com.example.l2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import com.google.gson.*;


class GFG {
    String name;
    String lastname;
    String middlename;
    Integer age;
    String language;

    public GFG() {
        this.name = "";
        this.lastname = "";
        this.middlename = "";
        this.age = 0;
        this.language = "";
    }
}

class User {
    private String name;
    private String lastname;
    private String middlename;
    private Integer age;
    private String language;

    public User(String name, String lastname, String middlename, Integer age, String language) {
        this.name = name;
        this.lastname = lastname;
        this.middlename = middlename;
        this.age = age;
        this.language = language;
    }
}
@WebServlet("/AddingServlet")
public class AddingServlet extends HttpServlet {
    ArrayList<User> user = new ArrayList<>();
    Integer i = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/addUserss.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GFG gfg;
        response.setContentType("application/json");
        String data = request.getParameter("data");
        String path = "C:\\Users\\HYPERPC\\IdeaProjects\\L2\\src\\main\\webapp\\json\\data.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gfg = gson.fromJson(data, GFG.class);
        String name = gfg.name;
        String lastname = gfg.lastname;
        String middlename = gfg.middlename;
        Integer age = gfg.age;
        String language = gfg.language;

        User users = new User(name, lastname, middlename, age, language);
        user.add(users);
        gson.toJson(user);

        try {
            Files.write(Paths.get(path), gson.toJson(user).getBytes());
        }catch (IOException e) {

        }
    }
}
