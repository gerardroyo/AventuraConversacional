import "./components.css";

type FooterProps = {
  text: string;
};

export function Footer({ text }: FooterProps) {
  return (
    <footer className="footer">
      <div className="container">{text}</div>
    </footer>
  );
}
