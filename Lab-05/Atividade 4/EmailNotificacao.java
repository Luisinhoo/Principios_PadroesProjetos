public class EmailNotificacao implements NotificacaoObserver {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}