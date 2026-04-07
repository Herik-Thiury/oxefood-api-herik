package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   @NotBlank(message = "O Título é de preenchimento obrigatório")
   @Length(max = 100, message = "O Título deverá ter no máximo {max} caracteres")
   private String titulo;

   @NotBlank(message = "O Código é de preenchimento obrigatório")
   private String codigo;

   @NotBlank(message = "A Descrição é de preenchimento obrigatório")
   private String descricao;

   @NotNull(message = "O Valor Unitário é de preenchimento obrigatório")
   private Double valorUnitario;

   @NotNull(message = "O Tempo de Entrega Mínimo é de preenchimento obrigatório")
   private Integer tempoEntregaMinimo;

   @NotNull(message = "O Tempo de Entrega Máximo é de preenchimento obrigatório")
   private Integer tempoEntregaMaximo;

   public Produto build() {
       return Produto.builder()
           .titulo(titulo)
           .codigo(codigo)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .tempoEntregaMinimo(tempoEntregaMinimo)
           .tempoEntregaMaximo(tempoEntregaMaximo)
           .build();
   }
}