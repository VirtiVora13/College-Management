package com.example.demo;

import com.example.demo.Entity.Subject;
import com.example.demo.Services.SubjectServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class demoTest {
	
	@Autowired
	private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

    @MockBean
    private SubjectServices subjectServices;

    //Student s1=new Student(1,"veda",2,"CE", 706);
    Subject subject = new Subject(1,"bcs",2);
    Subject subject2 = new Subject(2,"bcs",2);
    Subject subject3 = new Subject(3,"bcs",2);
    
    @Test
    public void getSubjectTest() throws Exception
    {


     	List<Subject> records = new ArrayList<>(Arrays.asList(subject,subject2,subject3));

    	Mockito.when(subjectServices.getSubject()).thenReturn(records);
    	mockMvc.perform ( MockMvcRequestBuilders
    			.get("/admin/get-subject")
    			.contentType(MediaType.APPLICATION_JSON))
    			.andExpect(content().string(objectMapper.writeValueAsString(records)))
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$[2].subjectName", is("bcs")));
    	
    }


}
