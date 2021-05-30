package interfaces.serviceInterfaces

interface CrudOperations<T> {
    fun save(entity: T)
    fun delete(id: Int)
    fun update(id: Int, entity: T)
    fun exist(id: Int): Boolean
    fun all(): List<T>
    fun getById(id: Int): T
}