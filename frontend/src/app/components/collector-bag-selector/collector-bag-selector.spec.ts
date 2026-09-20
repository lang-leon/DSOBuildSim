import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectorBagSelector } from './collector-bag-selector';

describe('CollectorBagSelector', () => {
  let component: CollectorBagSelector;
  let fixture: ComponentFixture<CollectorBagSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CollectorBagSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(CollectorBagSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
