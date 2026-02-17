package lucasdasial.mjobs.execptions;

public class UserAlreadyExistExecption extends RuntimeException {

    public UserAlreadyExistExecption() {
        super("Usuário já existe");
    }
}
