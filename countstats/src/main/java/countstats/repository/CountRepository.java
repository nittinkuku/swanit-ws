package countstats.repository;

import countstats.model.Count;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends CrudRepository<Count, Long> {
    @Query(value = "SELECT sum(pcm.count) FROM process_count_metric pcm WHERE pcm.process=?1 and pcm.identifier->>'study'=?2", nativeQuery = true)
    Long getCountForProcess(String process, String study);
}