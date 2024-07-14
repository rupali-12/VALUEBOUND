import javax.annotation.processing.SupportedOptions;

interface Notification {
    void send();
}

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending email notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending sms notification");
    }
}

class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending push notification");
    }
}

interface NotificationFactory {
    Notification createNotification();
}

class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

public class Factory_problem_2 {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        Notification emailNotification = emailFactory.createNotification();
        emailNotification.send();

        System.out.println();

        // Create an SMS notification using SMSNotificationFactory
        NotificationFactory smsFactory = new SMSNotificationFactory();
        Notification smsNotification = smsFactory.createNotification();
        smsNotification.send();

        System.out.println();

        // Create a push notification using PushNotificationFactory
        NotificationFactory pushFactory = new PushNotificationFactory();
        Notification pushNotification = pushFactory.createNotification();
        pushNotification.send();
    }
}
