import "./components.css";

type HeroProps = {
  title: string;
  subtitle: string;
  ctaLabel: string;
  onCtaClick?: () => void;
};

export function Hero({ title, subtitle, ctaLabel, onCtaClick }: HeroProps) {
  return (
    <section className="hero">
      <div className="container hero__content">
        <h1 className="hero__title">{title}</h1>
        <p className="hero__subtitle">{subtitle}</p>
        <button className="hero__cta" type="button" onClick={onCtaClick}>
          {ctaLabel}
        </button>
      </div>
    </section>
  );
}
