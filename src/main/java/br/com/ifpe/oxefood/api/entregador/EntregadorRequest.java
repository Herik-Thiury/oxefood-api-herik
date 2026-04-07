package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
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
public class EntregadorRequest {

   @NotBlank(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
   private String nome;

   @NotBlank(message = "O CPF é de preenchimento obrigatório")
   @CPF(message = "O CPF informado é inválido")
   private String cpf;

   @NotBlank(message = "O RG é de preenchimento obrigatório")
   private String rg;

   @NotNull(message = "A Data de Nascimento é de preenchimento obrigatório")
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   @NotBlank(message = "O Fone Celular é de preenchimento obrigatório")
   private String foneCelular;

   private String foneFixo;

   private Integer qtdEntregasRealizadas;
   
   @NotNull(message = "O Valor do Frete é obrigatório")
   private Double valorFrete;

   @NotBlank(message = "A Rua é obrigatória")
   private String enderecoRua;

   private String enderecoNumero;

   @NotBlank(message = "O Bairro é obrigatório")
   private String enderecoBairro;

   @NotBlank(message = "A Cidade é obrigatória")
   private String enderecoCidade;

   @NotBlank(message = "O CEP é obrigatório")
   private String enderecoCep;

   @NotBlank(message = "A UF é obrigatória")
   private String enderecoUf;

   private String enderecoComplemento;
   
   private Boolean ativo;

   public Entregador build() {
       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCidade(enderecoCidade)
           .enderecoCep(enderecoCep)
           .enderecoUf(enderecoUf)
           .enderecoComplemento(enderecoComplemento)
           .ativo(ativo)
           .build();
   }
}