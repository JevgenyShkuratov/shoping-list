package com.javaguru.shoppinglist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ExitProductAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println("Exit- Bye!");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
