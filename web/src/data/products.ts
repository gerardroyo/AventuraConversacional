export type ProductCategory = 'cameras' | 'camera-accessories';

export interface Product {
  id: string;
  name: string;
  category: ProductCategory;
  subcategory: string;
  price: number;
  image: string;
  highlights: string[];
  availability: boolean;
}

const ALLOWED_CATEGORIES: ReadonlySet<ProductCategory> = new Set([
  'cameras',
  'camera-accessories',
]);

const DRONE_RELATED_KEYWORDS = ['drone', 'drones', 'uav', 'quadcopter'];

const hasDroneRelatedText = (value: string): boolean => {
  const normalized = value.trim().toLowerCase();
  return DRONE_RELATED_KEYWORDS.some((keyword) => normalized.includes(keyword));
};

const isValidCategory = (category: string): category is ProductCategory =>
  ALLOWED_CATEGORIES.has(category as ProductCategory);

export const isAllowedProduct = (product: Product): boolean => {
  if (!isValidCategory(product.category)) {
    return false;
  }

  if (
    hasDroneRelatedText(product.category) ||
    hasDroneRelatedText(product.subcategory) ||
    hasDroneRelatedText(product.name)
  ) {
    return false;
  }

  return true;
};

export const filterBlockedProducts = (products: Product[]): Product[] =>
  products.filter(isAllowedProduct);

const rawProducts: Product[] = [
  {
    id: 'cam-001',
    name: 'Mirrorless 4K Pro',
    category: 'cameras',
    subcategory: 'mirrorless',
    price: 1299,
    image: '/images/products/mirrorless-4k-pro.jpg',
    highlights: ['4K 60fps', 'In-body stabilization', 'Fast autofocus'],
    availability: true,
  },
  {
    id: 'cam-002',
    name: 'Pocket Creator Cam',
    category: 'cameras',
    subcategory: 'compact',
    price: 599,
    image: '/images/products/pocket-creator-cam.jpg',
    highlights: ['Flip screen', 'Wide-angle lens', 'USB-C streaming'],
    availability: true,
  },
  {
    id: 'acc-001',
    name: 'Carbon Travel Tripod',
    category: 'camera-accessories',
    subcategory: 'tripods',
    price: 189,
    image: '/images/products/carbon-travel-tripod.jpg',
    highlights: ['Lightweight carbon fiber', 'Ball head included', 'Compact fold'],
    availability: false,
  },
];

export const products: Product[] = filterBlockedProducts(rawProducts);
