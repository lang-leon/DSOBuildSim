import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrinketTooltip } from './trinket-tooltip';

describe('TrinketTooltip', () => {
  let component: TrinketTooltip;
  let fixture: ComponentFixture<TrinketTooltip>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrinketTooltip],
    }).compileComponents();

    fixture = TestBed.createComponent(TrinketTooltip);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
