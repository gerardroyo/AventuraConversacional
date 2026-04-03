import "./components.css";

type CategoryTabsProps = {
  categories: string[];
  activeCategory: string;
  onCategoryChange?: (category: string) => void;
};

export function CategoryTabs({ categories, activeCategory, onCategoryChange }: CategoryTabsProps) {
  return (
    <div className="container" role="region" aria-label="Categorías de productos">
      <div className="category-tabs" role="tablist" aria-label="Filtrar por categoría">
        {categories.map((category) => {
          const isActive = category === activeCategory;
          return (
            <button
              key={category}
              type="button"
              className="category-tabs__button"
              role="tab"
              aria-selected={isActive}
              onClick={() => onCategoryChange?.(category)}
            >
              {category}
            </button>
          );
        })}
      </div>
    </div>
  );
}
