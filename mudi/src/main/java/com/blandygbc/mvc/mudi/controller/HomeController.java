package com.blandygbc.mvc.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blandygbc.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Redmi note 11");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/51e3KdrHuCL._AC_SL1080_.jpg");
        pedido.setUrlProduto(
                "https://www.amazon.com.br/Xiaomi-Redmi-Note-11-Graphite/dp/B09QSB4N2C?ref_=Oct_d_otopr_d_16243890011&pd_rd_w=cDjqV&content-id=amzn1.sym.ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_p=ecc25cc1-ec38-4678-aabf-b9da0181edb4&pf_rd_r=2H3DFCC0153PBSF31R5H&pd_rd_wg=qjVdv&pd_rd_r=4d962b17-6db5-40fb-890d-3733965b8081&pd_rd_i=B09QSB4N2C");
        // pedido.setDataDaEntrega(); //22/12/2022
        pedido.setDescricao(
                "Smartphone Xiaomi Redmi Note 11 Dual 128gb 6gb Ram - Graphite Gray/cinza - Global Tela AMOLED Mergulhe em um mundo de maravilhas A tela retroiluminada oferece o que há de mais moderno em brilho, contraste, calibração de cores e resolução. Taxa de atualização de 90Hz Ecrã e ecrã tátil sem falhas Desfrute do seu conteúdo com uma taxa de atualização suave e ininterrupta de 90Hz. Navegue sem problemas em suas redes sociais ou experimente uma jogabilidade poderosa e responsiva. Snapdragon 680 de 6 Desempenho completo, pronto para qualquer desafio Este processador não é apenas rápido e poderoso, mas também é executado no processo de 6 nm com eficiência energética para oferecer alto desempenho e aumentar a vida útil da bateria. Velocidades de carregamento mais rápidas com UFS 2.2 e escrita acelerada graças ao Write Booster, que oferece instalação eficiente de aplicativos, funções de inicialização e cache de arquivos em alta velocidade, bem como leitura e gravação de arquivos grandes. 33W Fast Charge Pro com 5000mAh Big Battery Carregue até 100% em cerca de uma hora com o 33W Fast Charge Pro* do Redmi Note 11, graças à nova tecnologia MMT do Redmi Note. Aproveite os benefícios transformadores do carregamento rápido. Poderosa câmera quádrupla de 50MP câmera principal de 50MP 8MP câmera ultra larga 2MP câmera macro 2MP câmera de profundidade Câmera Selfie de 13MP Imortalize cada momento glorioso e nunca perca nada. Dois alto-falantes estéreo Qualidade de áudio excepcional em cada nota Mais inteligente e prático Expansão de memória Motor linear do eixo Z Excelente Fonte padrão BR ou EUA (Enviado conforme disponibilidade) - Cabo carregador - Extrator de chip - Capinha - Manual");
        pedido.setValorNegociado(new BigDecimal(1372));

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
