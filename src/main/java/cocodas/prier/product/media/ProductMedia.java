package cocodas.prier.product.media;

import cocodas.prier.product.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ProductMedia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productMediaId;
    private String metadata;
    private String s3Key;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public ProductMedia(String metadata, String s3Key, Product product) {
        this.metadata = metadata;
        this.s3Key = s3Key;
        this.product = product;
    }

    public void changeMetadata(String metadata) {
        this.metadata = metadata;
    }

    public void changeS3Key(String s3Key) {
        this.s3Key = s3Key;
    }
}
