public class SMSNotificacao implements NotificacaoObserver {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}