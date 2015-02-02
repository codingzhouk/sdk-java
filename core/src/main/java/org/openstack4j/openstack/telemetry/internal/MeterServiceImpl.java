package org.openstack4j.openstack.telemetry.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.openstack4j.api.telemetry.MeterService;
import org.openstack4j.model.telemetry.Meter;
import org.openstack4j.model.telemetry.Sample;
import org.openstack4j.model.telemetry.SampleCriteria;
import org.openstack4j.model.telemetry.SampleCriteria.NameOpValue;
import org.openstack4j.model.telemetry.Statistics;
import org.openstack4j.openstack.common.ListEntity;
import org.openstack4j.openstack.telemetry.domain.CeilometerMeter;
import org.openstack4j.openstack.telemetry.domain.CeilometerSample;
import org.openstack4j.openstack.telemetry.domain.CeilometerStatistics;

/**
 * Provides Measurements against Meters within an OpenStack deployment
 * 
 * @author Jeremy Unruh
 */
public class MeterServiceImpl extends BaseTelemetryServices implements MeterService {

    private static final String FIELD = "q.field";
    private static final String OPER = "q.op";
    private static final String VALUE = "q.value";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Meter> list() {
        CeilometerMeter[] meters = get(CeilometerMeter[].class, uri("/meters")).execute();
        return wrapList(meters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Sample> samples(String meterName) {
        checkNotNull(meterName);

        CeilometerSample[] samples = get(CeilometerSample[].class, uri("/meters/%s", meterName)).execute();
        return wrapList(samples);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Sample> samples(String meterName, SampleCriteria criteria) {
        checkNotNull(meterName);

        Invocation<CeilometerSample[]> invocation = get(CeilometerSample[].class, uri("/meters/%s", meterName));
        if (criteria != null && !criteria.getCriteriaParams().isEmpty()) {
            for (NameOpValue c : criteria.getCriteriaParams()) {
                invocation.param(FIELD, c.getField());
                invocation.param(OPER, c.getOperator().getQueryValue());
                invocation.param(VALUE, c.getValue());
            }
        }

        CeilometerSample[] samples = invocation.execute();
        return wrapList(samples);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Statistics> statistics(String meterName) {
        return statistics(meterName, null, 0);
    }

    @Override
    public List<? extends Statistics> statistics(String meterName, int period) {
        return statistics(meterName, null, period);
    }

    @Override
    public List<? extends Statistics> statistics(String meterName, SampleCriteria criteria) {
        return statistics(meterName, criteria, 0);
    }

    @Override
    public List<? extends Statistics> statistics(String meterName, SampleCriteria criteria, int period) {
        checkNotNull(meterName);
        Invocation<CeilometerStatistics[]> invocation = get(CeilometerStatistics[].class, uri("/meters/%s/statistics", meterName))
                                                           .param(period > 0, "period", period);


        if (criteria != null && !criteria.getCriteriaParams().isEmpty()) {
            for (NameOpValue c : criteria.getCriteriaParams()) {
                invocation.param(FIELD, c.getField());
                invocation.param(OPER, c.getOperator().getQueryValue());
                invocation.param(VALUE, c.getValue());
            }
        }

        CeilometerStatistics[] stats = invocation.execute();
        return wrapList(stats);
    }

    @Override
    public void putSamples(List<Sample> sampleList, String meterName) {
        ListEntity<Sample> listEntity= new ListEntity<Sample>(sampleList);
        post(Void.class,uri("/meters/%s",meterName)).entity(listEntity).execute();
    }
}
