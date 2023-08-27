package pictolabeling.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is QueryForm.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryForm implements Serializable {
  @NotBlank
  @Size(max = 120)
  private String query;
}
