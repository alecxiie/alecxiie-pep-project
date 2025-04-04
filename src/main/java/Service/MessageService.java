package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    public MessageDAO messageDAO;

    public MessageService(){
        this.messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public List<Message> getAllMessages(){
        return this.messageDAO.getAllMessages();
    }

    public Message getMessageById(int id){
        return this.messageDAO.getMessageById(id);
    }

    public Message createMessage(Message message){
        String text = message.getMessage_text();
        if (text.length() > 255 || text.length() == 0){
            return null;
        }
        return this.messageDAO.insertMessage(message);
    }

    public Message deleteMessage(int id){
        Message res = this.messageDAO.getMessageById(id);
        if (res != null){
            this.messageDAO.deleteMessage(id);
        } 
        return res;
    }

    public Message updateMessage(int id, String message){
        if (
            this.messageDAO.getMessageById(id) == null
            || message.length() > 255 
            || message.length() == 0
        ){
            return null;
        }
        
        this.messageDAO.updateMessage(id, message);
        return this.messageDAO.getMessageById(id);
    }

    public List<Message> getAllMessagesFromAccountId(int id){
        return this.messageDAO.getAllMessagesPostedBy(id);
    }
}
