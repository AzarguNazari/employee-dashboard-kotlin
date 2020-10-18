package dashboard.service

interface DAO<T> {
    fun save(t: T)
    fun delete(id: Int)
    fun update(id: Int, t: T)
    fun getAll(): List<T>
    fun getById(id: Int): T
    fun exist(id: Int): Boolean
}