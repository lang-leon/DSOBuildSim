import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GemSelector } from './gem-selector';

describe('GemSelector', () => {
  let component: GemSelector;
  let fixture: ComponentFixture<GemSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GemSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(GemSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
