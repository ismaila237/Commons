package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class RootProjectAccessor extends TypeSafeProjectDependencyFactory {


    @Inject
    public RootProjectAccessor(DefaultProjectDependencyFactory factory, ProjectFinder finder) {
        super(factory, finder);
    }

    /**
     * Creates a project dependency on the project at path ":"
     */
    public FossifyCommonsProjectDependency getFossifyCommons() { return new FossifyCommonsProjectDependency(getFactory(), create(":")); }

    /**
     * Creates a project dependency on the project at path ":commons"
     */
    public CommonsProjectDependency getCommons() { return new CommonsProjectDependency(getFactory(), create(":commons")); }

    /**
     * Creates a project dependency on the project at path ":samples"
     */
    public SamplesProjectDependency getSamples() { return new SamplesProjectDependency(getFactory(), create(":samples")); }

}
