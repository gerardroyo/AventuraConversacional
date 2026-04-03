import ProductCard from './ProductCard';

export default function ProductSection({ id, title, subtitle, items }) {
  return (
    <section id={id} className="product-section">
      <div className="section-heading">
        <h2>{title}</h2>
        <p>{subtitle}</p>
      </div>
      <div className="product-grid">
        {items.map((item) => (
          <ProductCard key={item.name} {...item} />
        ))}
      </div>
    </section>
  );
}
