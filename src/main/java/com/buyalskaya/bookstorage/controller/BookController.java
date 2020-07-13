package com.buyalskaya.bookstorage.controller;

import com.buyalskaya.bookstorage.controller.command.Command;

import java.util.Map;

public class BookController {

    public void processRequest(String commandName, Map<String, String> parameters) {
        Command command = ActionProvider.defineCommand(commandName);
        Map<String, String> response = command.execute(parameters);
    }
}