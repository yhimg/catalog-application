# catalog-application

## API Endpoints

### Catalog Endpoints


| SNo|Endpoints | HTTP Method  | Description  |
| --- |------- | --- | --- |
| 1 |/category | POST | Create a category for catalog. |
| 2 |/category/{categoryId}/attributes | POST | Create category attributes for a categoryId |
| 3 |/product | POST | create product|
| 4 |/product/{productId} | GET | Display a product, its attribute and its category attributes |
| 5 |/category/{categoryId}/attributes | GET | display attributes belongs to a category|
| 6 |/category/{categoryId} | GET | display a category |
| 7 |/product | GET | Display all products, their attributes and category attributes|


### Dummy Data for APIs:

1. ```json
   {
    "categoryName": "Apparel"
   }
   
2. ```json
   [
        {
            "attributeName": "Brand",
            "attributeValue": "LEE"
        },
        {
            "attributeName": "Size",
            "attributeValue": "M"
        },
        {
            "attributeName": "Type",
            "attributeValue": "Shirt"
        }
    ]

3. ```json
       {
        "productName": "Red Strip Kurta",
        "categoryId": 1,
        "productAttributes": [
            {
                "attributeName": "Sleeve Length",
                "attributeValue": "Full"
            },
            {
                "attributeName": "Collar",
                "attributeValue": "Mandarin"
            }
        ]
    }
   
## SQL Queries to Create Table:

```mysql
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `category_name` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_category_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_name` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_product_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `category_attributes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `attribute_name` varchar(255) NOT NULL,
  `attribute_value` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_category_attributes_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_attributes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `attribute_name` varchar(255) NOT NULL,
  `attribute_value` varchar(255) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `prodduct_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_product_attributes_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;