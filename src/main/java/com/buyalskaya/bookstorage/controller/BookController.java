package com.buyalskaya.bookstorage.controller;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.utility.Response;

import java.util.Map;

public class BookController {

    public void processRequest(String commandName, Map<String, String> parameters,
                               Response response) {
        Command command = ActionProvider.defineCommand(commandName);
        response = command.execute(parameters);
    }
}