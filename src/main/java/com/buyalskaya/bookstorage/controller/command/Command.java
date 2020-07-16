package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.utility.Response;

import java.util.Map;

public interface Command {
    Response execute(Map<String,String> parameters);
}