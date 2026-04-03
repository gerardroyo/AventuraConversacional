import "./components.css";

export type Product = {
  id: string;
  name: string;
  description: string;
  price: string;
  imageUrl: string;
};

type ProductCardProps = {
  product: Product;
  onAdd?: (product: Product) => void;
};

export function ProductCard({ product, onAdd }: ProductCardProps) {
  return (
    <article className="product-card">
      <img className="product-card__media" src={product.imageUrl} alt={product.name} loading="lazy" />
      <div className="product-card__body">
        <h3 className="product-card__title">{product.name}</h3>
        <p className="product-card__description">{product.description}</p>
        <div className="product-card__footer">
          <span className="product-card__price">{product.price}</span>
          <button className="product-card__button" type="button" onClick={() => onAdd?.(product)}>
            Añadir
          </button>
        </div>
      </div>
    </article>
  );
}
