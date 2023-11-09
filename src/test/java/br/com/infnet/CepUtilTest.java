package br.com.infnet;

import br.com.infnet.model.Endereco;
import br.com.infnet.util.CepUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CepUtilTest {
    @Test
    public void deveReTornarUmEnderecoParaoCep(){
        CepUtil cepUtil = new CepUtil();
        Endereco enderecoFromCep = cepUtil.getEnderecoFromCep("24040020");
        assertEquals("Rua Comendador Ilidio Afonso Soares", enderecoFromCep.getLogradouro());
    }

}
