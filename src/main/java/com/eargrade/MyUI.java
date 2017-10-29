package com.eargrade;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource resource = new FileResource(new File(basepath + "/WEB-INF/classes/original.png"));
        Image logo = new Image("EarGrade - your way to the music", resource);
        logo.setWidth("200px");logo.setHeight("120px");

        HorizontalLayout authorize = new HorizontalLayout();
        VerticalLayout form = new VerticalLayout();
        TextField username = new TextField("Username");
        final TextField yourId = new TextField("Enter ID of your EarGrade");
        yourId.setVisible(false);
        Button log = new Button("Log in");
        log.addClickListener(e -> {
            //TODO authorize
            //if don't have a username for any id
            yourId.setVisible(true);
            //TODO register new user
        });
        log.addStyleName("login");
        form.addComponents(username, yourId);
        authorize.addComponents(form, log);

        HorizontalLayout melodying = new HorizontalLayout();
        Button download = new Button("Download song");
        download.addStyleName("download");
        download.addClickListener(e->{
            //TODO set last melody on chosen and send melody
        });
        ComboBox<String> melody = new ComboBox<>("Choose melody");
        ArrayList<String> melodyStructure = new ArrayList<>();
        Collections.addAll(melodyStructure, "Tetris", "Snowy Tree");
        melody.setItems(melodyStructure);
        melody.addSelectionListener(e ->{
            //TODO correct scoreboard via data
        });
        melodying.addComponents(melody, download);


        List<Record> scoreboard = Arrays.asList(new Record("Havlong", 100)
                , new Record("Mapk58", 20)
                , new Record("MrHamsterGG", 80));
        Grid<Record> board = new Grid<>();
        board.setItems(scoreboard);
        board.addColumn(Record::getUsername).setCaption("User");
        board.addColumn(Record::getScore).setCaption("Record");

        layout.addComponents(logo, authorize, melodying, board);

        setContent(layout);
     }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    private class Record{
        String username;
        int score;

        Record(String username, int score){
            this.username = username;
            this.score = score;
        }

        int getScore() {
            return score;
        }

        String getUsername() {
            return username;
        }
    }
}
