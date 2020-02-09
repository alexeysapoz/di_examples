package services

trait NotificationService {
  def sendNotification(receiverAccount: String, text: String): Unit
}
