package platform;

public class CodeService {

    public Code getCode() {
        return new Code("public static void main(String[] args) {\n\tSpringApplication.run(CodeSharingPlatform.class, args);\n}");
    }
}
