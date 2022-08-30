package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    @RequestMapping(value = "/student/add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student_form","command",new Student());
    }
    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("student/student_form","command",student);
            model.addObject("errors",result);
            return model;
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/student.view");
        mv.addObject("student",student);
       if(student.getId() > 0){
           studentDAO.update(student);
       }else{
           studentDAO.insert(student);
       }
        return new ModelAndView("redirect:/student/list");
    }
    @RequestMapping(value = "/student/list",method = RequestMethod.GET)
    public ModelAndView listStudent(@RequestParam(value = "q",required = false) String query){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student.list");
        mv.addObject("students",studentDAO.list());
        return mv;
    }
    @RequestMapping(value = "/student/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        studentDAO.deleteById(id);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        Student student = studentDAO.getById(id);
        System.out.println("Student: "+student.getName());
        return new ModelAndView("/student/student_form","command",student);
    }
    @RequestMapping(value = "student/edit/save",method = RequestMethod.POST)
    public String saveEdit(){
        return "forward:/student/save";
    }
    @RequestMapping(value = "student/json/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Student viewJson(@PathVariable Integer id){
        return studentDAO.getById(id);
    }
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String home(){
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/avatar/save",method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("file")MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "student.error";
        }
        byte[] bytes = file.getBytes();
        System.out.println("found --> "+bytes.length);
        return "redirect:/student/list";
    }
    private File getImageFile(HttpServletRequest request, Integer id){
        ServletContext servletContext = request.getSession().getServletContext();
        String diskPath = servletContext.getRealPath("/");
        File folder = new File(diskPath + File.separator + "avatar" + File.separator);
        folder.mkdirs();
        return new File(folder,String.valueOf(id)+".jpg");
    }
}
