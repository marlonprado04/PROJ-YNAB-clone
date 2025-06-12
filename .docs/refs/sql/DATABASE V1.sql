CREATE TABLE `Account` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `type` enum,
  `currentBalance` decimal,
  `isBudgetIncluded` boolean,
  `balanceDate` date,
  `createdAt` timestamp,
  `updatedAt` timestamp
);

CREATE TABLE `Category` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `createdAt` timestamp,
  `updatedAt` timestamp
);

CREATE TABLE `Subcategory` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `categoryId` bigint,
  `createdAt` timestamp,
  `updatedAt` timestamp
);

CREATE TABLE `Transaction` (
  `id` bigint PRIMARY KEY,
  `accountId` bigint,
  `subcategoryId` bigint,
  `payee` varchar(255),
  `description` varchar(255),
  `amount` decimal,
  `date` date,
  `operation` enum,
  `transferGroupId` uuid,
  `recurrence` enum,
  `recurrenceFrequency` enum,
  `installmentCount` int,
  `groupId` uuid,
  `isCleared` boolean,
  `createdAt` timestamp,
  `updatedAt` timestamp
);

CREATE TABLE `Budget` (
  `id` bigint PRIMARY KEY,
  `subcategoryId` bigint,
  `month` int,
  `year` int,
  `plannedAmount` decimal,
  `actualAmount` decimal,
  `createdAt` timestamp,
  `updatedAt` timestamp
);

ALTER TABLE `Subcategory` ADD FOREIGN KEY (`categoryId`) REFERENCES `Category` (`id`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`accountId`) REFERENCES `Account` (`id`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`subcategoryId`) REFERENCES `Subcategory` (`id`);

ALTER TABLE `Budget` ADD FOREIGN KEY (`subcategoryId`) REFERENCES `Subcategory` (`id`);
