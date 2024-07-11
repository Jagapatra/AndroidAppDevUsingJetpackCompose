class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts(): List<Product> {
        return  apiService.getProducts()
    }
}
