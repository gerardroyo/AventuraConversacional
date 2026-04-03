export default function ProductCard({ name, description, price, badge }) {
  return (
    <article className="product-card">
      <span className="product-card__badge">{badge}</span>
      <h3>{name}</h3>
      <p>{description}</p>
      <strong>{price}</strong>
    </article>
  );
}
