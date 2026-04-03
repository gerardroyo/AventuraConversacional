import "./components.css";

type HeaderProps = {
  brand: string;
  links: Array<{ label: string; href: string }>;
};

export function Header({ brand, links }: HeaderProps) {
  return (
    <header className="header">
      <div className="container header__inner">
        <a className="header__brand" href="/" aria-label={`${brand} inicio`}>
          {brand}
        </a>
        <nav className="header__nav" aria-label="Navegación principal">
          {links.map((link) => (
            <a key={link.href} className="header__link" href={link.href}>
              {link.label}
            </a>
          ))}
        </nav>
      </div>
    </header>
  );
}
