package ch.rasc.immutables;

import org.immutables.criteria.Criteria;
import org.immutables.value.Value;

@Value.Immutable
@Criteria
@Criteria.Repository
// @Criteria.Repository(facets = {SyncReadable.class, SyncWritable.class})
interface Person {
	@Criteria.Id
	String id();

	String fullName();
}