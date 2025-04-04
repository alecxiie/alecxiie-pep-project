package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);

        app.post("/register", this::postAccountHandler);
        app.post("/login", this::loginHandler);
        app.get("/messages", this::getAllMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIdHandler);
        app.delete("/messages/{message_id}", this::deleteMessageHandler);
        app.patch("/messages/{message_id}", this::patchMessageByIdHandler);
        app.get("/accounts/{account_id}/messages", this::getAllMessagesFromAccountIdHandler);

        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }

    private void postAccountHandler(Context context) {
        ObjectMapper mapper = new ObjectMapper();
        Author author = mapper.readValue(context.body(), Author.class);
        Author addedAuthor = authorService.addAuthor(author);
        if(addedAuthor!=null){
            context.json(mapper.writeValueAsString(addedAuthor));
        }else{
            context.status(400);
        }
    }
    private void loginHandler(Context context) {
        context.json("sample text");
    }
    private void getAllMessagesHandler(Context context) {
        context.json("sample text");
    }
    private void getMessageByIdHandler(Context context) {
        context.json("sample text");
    }
    private void deleteMessageHandler(Context context) {
        context.json("sample text");
    }
    private void patchMessageByIdHandler(Context context) {
        context.json("sample text");
    }
    private void getAllMessagesFromAccountIdHandler(Context context) {
        context.json("sample text");
    }


}