import Hero from '../components/Hero';
import ProductSection from '../components/ProductSection';

const cameraData = [
  {
    name: 'DJI Osmo Action 5 Pro',
    description: 'Sensor de alto rango dinámico, 4K120 y estabilización RockSteady 4.0.',
    price: '€449',
    badge: 'Cámara de acción'
  },
  {
    name: 'DJI Osmo Action 4',
    description: 'Rendimiento en baja luz y color de 10 bits para creadores exigentes.',
    price: '€379',
    badge: 'Cámara de acción'
  },
  {
    name: 'DJI Osmo Action 3',
    description: 'Diseño resistente, grabación 4K y pantalla frontal táctil.',
    price: '€299',
    badge: 'Cámara de acción'
  }
];

const accessoryData = [
  {
    name: 'Adventure Combo Mount Kit',
    description: 'Anclajes rápidos para casco, manillar y pecho con ajuste seguro.',
    price: '€89',
    badge: 'Accesorio'
  },
  {
    name: 'Batería Extreme Plus',
    description: 'Autonomía extendida y rendimiento estable en condiciones frías.',
    price: '€49',
    badge: 'Accesorio'
  },
  {
    name: 'Micrófono DJI Mini Audio',
    description: 'Captura de voz clara para vlogs y tomas en movimiento.',
    price: '€119',
    badge: 'Accesorio'
  }
];

export default function HomePage() {
  return (
    <div className="layout">
      <header className="topbar">
        <div className="brand">DJI Action Hub</div>
        <nav>
          <a href="#camaras">Cámaras</a>
          <a href="#accesorios">Accesorios</a>
          <a href="#cta">Ofertas</a>
        </nav>
      </header>

      <main>
        <Hero />

        <section className="filters" aria-label="Filtros de producto">
          <span>Filtros activos:</span>
          <button type="button">Solo cámaras DJI</button>
          <button type="button">Solo accesorios DJI</button>
          <button type="button" className="excluded">Drones excluidos</button>
        </section>

        <ProductSection
          id="camaras"
          title="Cámaras de acción DJI"
          subtitle="Comparativa rápida de modelos para deporte, viaje y contenido diario."
          items={cameraData}
        />

        <ProductSection
          id="accesorios"
          title="Accesorios para cámaras"
          subtitle="Expande tu setup con monturas, audio y energía adicional."
          items={accessoryData}
        />

        <section id="cta" className="cta">
          <h2>¿Listo para tu próxima aventura?</h2>
          <p>
            Configura tu kit DJI de acción hoy. Recibe asesoría para cámaras y accesorios,
            con exclusión explícita de drones en todo el flujo.
          </p>
          <a href="#" className="btn btn--primary">Crear mi kit</a>
        </section>
      </main>

      <footer className="footer">
        <p>© 2026 DJI Action Hub</p>
        <p>Catálogo centrado en cámaras de acción y accesorios (sin drones).</p>
      </footer>
    </div>
  );
}
