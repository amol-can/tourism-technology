# Tourism Technology Festival Hackathon


## API Documentation

The API documentation for this project is generated using Springdoc OpenAPI UI. You can access the API documentation at the following URL:

```<base-server-path>/pay-pay/swagger-ui/index.html```
example: http://localhost:8085/pay-pay/swagger-ui/index.html

## API Endpoints

This application provides the following API endpoints:

**TransactionController**

- `GET /api/transactions`: Returns a list of all transactions.
- `GET /api/transactions/client/{id}`: Returns a list of transactions for a specific client, identified by `{id}`.
- `GET /api/transactions/business/{id}`: Returns a list of transactions for a specific business, identified by `{id}`.
- `GET /api/transactions/{id}`: Returns a specific transaction, identified by `{id}`.
- `POST /api/transactions`: Creates a new transaction. The transaction data should be included in the request body.
- `DELETE /api/transactions/{id}`: Deletes a specific transaction, identified by `{id}`.

**RewardController**

- `GET /api/rewards`: Returns a list of all rewards.
- `GET /api/rewards/{id}`: Returns a list of rewards for a specific business, identified by `{id}`.
- `POST /api/rewards`: Creates a new reward. The reward data should be included in the request body.
- `POST /api/rewards/claim`: Claims a reward. The claim request data should be included in the request body.

**PointController**

- `GET /api/points/user/{id}`: Returns the total points for a specific user, identified by `{id}`.

Please replace `{id}` with the actual IDs when making requests.

## Frontend Application

The frontend application is located in the `frontend-app` folder. It uses React with TypeScript and Vite for a fast and modern web development experience.

### Key Features

- Minimal setup with React working in Vite with Hot Module Replacement (HMR) and some ESLint rules.
- Two official plugins are available: `@vitejs/plugin-react` (uses Babel for Fast Refresh) and `@vitejs/plugin-react-swc` (uses SWC for Fast Refresh).
- ESLint configuration can be expanded for production applications to enable type aware lint rules.

For more details, please refer to the `README.md` file in the `frontend-app` folder.

## Running the Application

### Running the Spring Boot Application

To run the Spring Boot application, navigate to the root directory of the project in your terminal and run the following command:

```bash
./mvnw spring-boot:run
```

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## Open Source
This project is open source under the MIT license. See the LICENSE file for more information.