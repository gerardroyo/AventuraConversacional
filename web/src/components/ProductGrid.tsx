import { ProductCard, type Product } from "./ProductCard";
import "./components.css";

type ProductGridProps = {
  products: Product[];
  onAdd?: (product: Product) => void;
};

export function ProductGrid({ products, onAdd }: ProductGridProps) {
  return (
    <section className="container product-grid" aria-label="Listado de productos">
      {products.map((product) => (
        <ProductCard key={product.id} product={product} onAdd={onAdd} />
      ))}
    </section>
  );
}
