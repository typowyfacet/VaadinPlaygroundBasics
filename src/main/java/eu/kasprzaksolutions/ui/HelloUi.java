package eu.kasprzaksolutions.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;


@SpringUI(path = "/UI")
@Theme("valo")
public class HelloUi extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
    }

}
